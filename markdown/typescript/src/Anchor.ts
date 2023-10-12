export class Anchor {
    constructor(public readonly url: string, public readonly text: string) {}

    static fromMarkdownExpression(markdownAnchor: string): Anchor {
        const separator = "](";
        const start = "[".length;
        const visibleText = markdownAnchor.substring(start, markdownAnchor.indexOf(separator))
        const closingTag = ")";
        const end = markdownAnchor.indexOf(closingTag, start);
        const url = markdownAnchor.substring(markdownAnchor.indexOf(separator) + separator.length, end)

        return new Anchor(url, visibleText)
    }

    isEqual(item: Anchor) {
        return this.url === item.url && this.text === item.text;
    }
}