import {FakeRecorder, FakeSensor, SurveillanceController} from "../core/surveillance-controller";

describe("Surveillance Controller", () => {
    it("instructs the recorder to stop recording when the motion sensor does not detect movement", () => {
        const fakeRecorder = new FakeRecorder();
        const fakeSensor = new FakeSensor();
        const controller = new SurveillanceController(fakeRecorder, fakeSensor);
        const spyRecorder = jest.spyOn(fakeRecorder, "stopRecording")

        controller.recordMotion()

        expect(spyRecorder).toHaveBeenCalled()
    })

    it("Instructs the recorder to start recording when the motion sensor detects movement.", () => {
        const fakeRecorder = new FakeRecorder();
        const fakeSensor = new FakeSensor();
        const controller = new SurveillanceController(fakeRecorder, fakeSensor);
        const spyRecorder =jest.spyOn(fakeRecorder, "startRecording")
        const spySensor = jest.spyOn(fakeSensor, "isDetectingMotion")
        spySensor.mockImplementation(() => true)

        controller.recordMotion()

        expect(spyRecorder).toHaveBeenCalled()
    })
})