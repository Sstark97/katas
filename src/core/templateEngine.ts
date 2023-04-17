import type { Replacement } from "./Replacement"

function areEmptyParameters(text: string, replacements: Replacement) {
    return text === "" || Object.keys(replacements).length === 0
}

function extractAppearanceInfoFrom(currentElement: string) {
    const variableToFind = /\$\{(.*?)}/
    const [textToReplace, key] = currentElement.match(variableToFind)
    return { textToReplace, key }
}

function toReplacedText(currentElement: string, replacements: Replacement, text: string) {
    const { textToReplace, key} = extractAppearanceInfoFrom(currentElement)
    const replacementValue = replacements[key]

    return text.replace(textToReplace, replacementValue)
}

function extractAllAppearancesFrom(text: string) {
    const findAllAppearances = /\$\{(.*?)}/g
    return text.match(findAllAppearances)
}

function textMatchWith(replacements: Replacement, allAppearances: RegExpMatchArray) {
    const allAppearancesMatch = allAppearances.some((currentElement) => {
        const { key} = extractAppearanceInfoFrom(currentElement)
        return Object.keys(replacements).includes(key)
    })

    return Object.keys(replacements).length === allAppearances.length && allAppearancesMatch
}

export function templateEngineConverterFrom(text: string, replacements: Replacement) {
    if (areEmptyParameters(text, replacements)) {
        return text
    }

    const allAppearances = extractAllAppearancesFrom(text)
    if (textMatchWith(replacements, allAppearances)) {
        return allAppearances.reduce((previousElement, currentElement) => (
            text = toReplacedText(currentElement, replacements, text)
        ), "")
    }

    throw new Error("Text doesn't match replacements keys")
}