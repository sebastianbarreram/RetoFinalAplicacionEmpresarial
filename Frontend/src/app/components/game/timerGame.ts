import { Observable, Subject, Subscription, timer } from "rxjs";

export class TimerGame {
	private subject: Subject<string> = new Subject();

	private seconds: number = 0;

	constructor() {
		const subscription: Subscription = timer(1000, 1000).subscribe((time) => {
			if (time > (this.seconds - 1)) {
				subscription.unsubscribe();
				this.subject.complete();
			} else {
				this.subject.next(String(this.seconds - time));
			}
		});
	}

	setSeconds(seconds: number): void {
		this.seconds = seconds;
	}

	getObservable(): Observable<String> {
		return this.subject.asObservable();
	}
}
