import {MouseEventType, MouseEventListener, Mouse} from "../core/Mouse"

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
})