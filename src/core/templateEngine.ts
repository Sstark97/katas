import type { Replacement } from "./Replacement"

function areEmptyParameters(chain: string, replacements: Replacement) {
    return chain === "" || Object.keys(replacements).length === 0
}

function extractAppearanceInfoFrom(currentElement: string) {
    const variableToFind = /\$\{(.*?)}/
    const [textToReplace, key] = currentElement.match(variableToFind)
    return { textToReplace, key }
}

function toReplacedChain(currentElement: string, replacements: Replacement, chain: string) {
    const { textToReplace, key} = extractAppearanceInfoFrom(currentElement)
    const replacementValue = replacements[key]

    return chain.replace(textToReplace, replacementValue)
}

function extractAllAppearancesFrom(chain: string) {
    const findAllAppearances = /\$\{(.*?)}/g
    return chain.match(findAllAppearances)
}

function textMatchWith(replacements: Replacement, allAppearances: RegExpMatchArray) {
    const allAppearancesMatch = allAppearances.some((currentElement) => {
        const { key} = extractAppearanceInfoFrom(currentElement)
        return Object.keys(replacements).includes(key)
    })

    return Object.keys(replacements).length === allAppearances.length && allAppearancesMatch
}

export function templateEngineConverterFrom(chain: string, replacements: Replacement) {
    if (areEmptyParameters(chain, replacements)) {
        return chain
    }

    const allAppearances = extractAllAppearancesFrom(chain)
    if (textMatchWith(replacements, allAppearances)) {
        return allAppearances.reduce((previousElement, currentElement) => (
            chain = toReplacedChain(currentElement, replacements, chain)
        ), "")
    }

    throw new Error("Text doesn't match replacements keys")
}