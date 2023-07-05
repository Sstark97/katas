import {
    FakeRecorder,
    FakeSensor,
    MotionSensor,
    SurveillanceController,
    VideoRecorder
} from "../core/surveillance-controller";

describe("Surveillance Controller", () => {
    let fakeRecorder: VideoRecorder
    let fakeSensor: MotionSensor
    let controller: SurveillanceController

    beforeEach(() => {
        fakeRecorder = new FakeRecorder();
        fakeSensor = new FakeSensor();
        controller = new SurveillanceController(fakeRecorder, fakeSensor);
    })

    it("instructs the recorder to stop recording when the motion sensor does not detect movement", () => {
        const spyRecorder = jest.spyOn(fakeRecorder, "stopRecording")

        controller.recordMotion()

        expect(spyRecorder).toHaveBeenCalled()
    })

    it("Instructs the recorder to start recording when the motion sensor detects movement.", () => {
        const spyRecorder =jest.spyOn(fakeRecorder, "startRecording")
        const spySensor = jest.spyOn(fakeSensor, "isDetectingMotion")
        spySensor.mockImplementation(() => true)

        controller.recordMotion()

        expect(spyRecorder).toHaveBeenCalled()
    })
})