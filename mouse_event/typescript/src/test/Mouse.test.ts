import {MouseEventType, MouseEventListener, Mouse, MousePointerCoordinates} from "../core/Mouse"

describe('Mouse', () => {
    it('notifies single click', () => {
        const mouse = new Mouse()
        const time = new Date().getTime();
        let mouseEventListener: MouseEventListener = {
            handleMouseEvent: jest.fn()
        };

        mouse.subscribe(mouseEventListener)
        mouse.pressLeftButton(time)
        mouse.releaseLeftButton(time + 10)

        expect(mouseEventListener.handleMouseEvent).toHaveBeenCalledWith(MouseEventType.SingleClick)
    })

    it('does not notify anything if only release button', () => {
        const mouse = new Mouse()
        const time = new Date().getTime();
        let mouseEventListener: MouseEventListener = {
            handleMouseEvent: jest.fn()
        };

        mouse.subscribe(mouseEventListener)
        mouse.releaseLeftButton(time)

        expect(mouseEventListener.handleMouseEvent).not.toHaveBeenCalled()
    })

    it('notifies drag', () => {
        const mouse = new Mouse()
        const time = new Date().getTime();
        const from = new MousePointerCoordinates(0,0)
        const to = new MousePointerCoordinates(10,10)
        let mouseEventListener: MouseEventListener = {
            handleMouseEvent: jest.fn()
        };

        mouse.subscribe(mouseEventListener)
        mouse.pressLeftButton(time)
        mouse.move(from,to,time + 10)

        expect(mouseEventListener.handleMouseEvent).toHaveBeenCalledWith(MouseEventType.Drag)
    })

    it('does not notifies anything if only moves', () => {
        const mouse = new Mouse()
        const time = new Date().getTime();
        const from = new MousePointerCoordinates(0,0)
        const to = new MousePointerCoordinates(10,10)
        let mouseEventListener: MouseEventListener = {
            handleMouseEvent: jest.fn()
        };

        mouse.subscribe(mouseEventListener)
        mouse.move(from,to,time + 10)

        expect(mouseEventListener.handleMouseEvent).not.toHaveBeenCalled()
    })
})