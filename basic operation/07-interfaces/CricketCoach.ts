import { Coach } from "./Coach";

export class CricketCoach implements Coach {
    getDailyWorkout(): string {
        return "Practice spinning bowling.";
    }

}