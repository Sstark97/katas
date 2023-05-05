# Mouse Events Kata #

This kata is part of the book ["Código sostenible"](https://codigosostenible.com).

Test-drive the methods missing the implementation:

```typescript

class Mouse {
    private listeners: MouseEventListener[] = [];
    private timeWindowInMillisecondsForDoubleClick = 500;

    public pressLeftButton(currentTimeInMilliseconds: number) {
        /*... implement this method ...*/
    }

    public releaseLeftButton(currentTimeInMilliseconds: number) {
        /*... implement this method ...*/
    }

    public move(
        from: MousePointerCoordinates,
        to: MousePointerCoordinates,
        currentTimeInMilliseconds: number
    ) {
        /*... implement this method ...*/
    }

    public subscribe(listener: MouseEventListener) {
        this.listeners.push(listener);
    }

    private notifySubscribers(eventType: MouseEventType) {
        this.listeners.forEach((listener) => listener.handleMouseEvent(eventType));
    }
}

enum MouseEventType {
    SingleClick = "SingleClick",
    DoubleClick = "DoubleClick",
    TripleClick = "TripleClick",
    Drag = "Drag",
    Drop = "Drop"
}

interface MouseEventListener {
    handleMouseEvent(eventType: MouseEventType );
}

class MousePointerCoordinates {
    private x: number;
    private y: number;
}

```
