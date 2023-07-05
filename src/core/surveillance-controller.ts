export const saidHello = message => `Hello ${message}!`

interface MotionSensor {
    isDetectingMotion(): boolean;
}

interface VideoRecorder {
    startRecording(): void;

    stopRecording(): void;
}

export class FakeRecorder implements VideoRecorder {
    startRecording(): void {
    }

    stopRecording(): void {
    }

}

export class FakeSensor implements MotionSensor {
    isDetectingMotion(): boolean {
        return false;
    }
}

export class SurveillanceController {
    constructor(private readonly fakeRecorder: VideoRecorder, private readonly fakeSensor: MotionSensor) {
    }

    recordMotion() {
        if (!this.fakeSensor.isDetectingMotion()) {
            this.fakeRecorder.stopRecording()
        }
    }
}