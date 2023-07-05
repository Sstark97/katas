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
    constructor(private readonly fakeRecorder: VideoRecorder, private readonly fakeSensor: MotionSensor) {}

    recordMotion() {
        if(!this.fakeSensor.isDetectingMotion()) {
            this.fakeRecorder.stopRecording()
        }
    }
}

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