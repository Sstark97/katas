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
    constructor(private readonly recorder: VideoRecorder, private readonly sensor: MotionSensor) {}

    recordMotion() {
        this.sensor.isDetectingMotion() ? this.recorder.startRecording() : this.recorder.stopRecording()
    }
}