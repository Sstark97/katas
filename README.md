# Mouse Events Kata #

This kata is part of the book ["Código sostenible"](https://codigosostenible.com).

Test-drive the methods missing the implementation:

```java

public class Mouse {
    private List<MouseEventListener> listeners = new ArrayList<>();
    private final long timeWindowInMillisecondsForDoubleClick = 500;

    public void pressLeftButton(long currentTimeInMilliseconds) {
        /*... implement this method ...*/
    }

    public void releaseLeftButton(long currentTimeInMilliseconds) {
        /*... implement this method ...*/
    }

    public void move(MousePointerCoordinates from, MousePointerCoordinates to, long
            currentTimeInMilliseconds) {
        /*... implement this method ...*/
    }

    public void subscribe(MouseEventListener listener) {
        listeners.add(listener);
    }

    private void notifySubscribers(MouseEventType eventType) {
        listeners.forEach(listener -> listener.handleMouseEvent(eventType));
    }
}

enum MouseEventType {
    SingleClick,
    DoubleClick,
    TripleClick,
    Drag,
    Drop
}

interface MouseEventListener {
    void handleMouseEvent(MouseEventType eventType);
}

```
