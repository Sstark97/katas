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

    it("Instructs the recorder to start recording when the motion sensor detects movement.", () => {
        let called = false
        const fakeRecorder = new FakeRecorder();
        fakeRecorder.startRecording = () => called = true
        const fakeSensor = new FakeSensor();
        fakeSensor.isDetectingMotion = () => true
        const controller = new SurveillanceController(fakeRecorder, fakeSensor);

        controller.recordMotion()

        expect(called).toBeTruthy()
    })
})