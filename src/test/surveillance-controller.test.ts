import { saidHello} from "../core/example";

interface MotionSensor {
    isDetectingMotion(): boolean;
}

interface VideoRecorder {
    startRecording(): void;
    stopRecording(): void;
}

class FakeRecorder implements VideoRecorder {
    startRecording(): void {
    }

    stopRecording(): void {
    }

}

class FakeSensor implements MotionSensor{
    isDetectingMotion(): boolean {
        return false;
    }
}

class SurveillanceController {
    constructor(fakeRecorder: VideoRecorder, fakeSensor: MotionSensor) {

    }

    recordMotion() {

    }
}

describe("Surveillance Controller", () => {
    it("instructs the recorder to stop recording when the motion sensor does not detect movement", () => {
        const fakeRecorder = new FakeRecorder();
        const fakeSensor = new FakeSensor();
        const controller = new SurveillanceController(fakeRecorder, fakeSensor);

        controller.recordMotion()

        expect(fakeSensor.isDetectingMotion).toHaveBeenCalled()
        expect(fakeRecorder.stopRecording).toHaveBeenCalled()
    })
})