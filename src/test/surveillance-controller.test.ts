import {FakeRecorder, FakeSensor, SurveillanceController} from "../core/surveillance-controller";

describe("Surveillance Controller", () => {
    it("instructs the recorder to stop recording when the motion sensor does not detect movement", () => {
        let called = false
        const fakeRecorder = new FakeRecorder();
        fakeRecorder.stopRecording = () => called = true
        const fakeSensor = new FakeSensor();
        const controller = new SurveillanceController(fakeRecorder, fakeSensor);

        controller.recordMotion()

        expect(called).toBeTruthy()
    })
})