import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  public resourceUrl = SERVER_API_URL + 'api/post';

  constructor(private http: HttpClient) { }

  likeTransaction(id: Number): Observable<any> {
    return this.http.get(this.resourceUrl + "/likes/" + id);
  }

  newEventSource(id: Number): EventSource {
    return new EventSource(this.resourceUrl + "/likes/" + id);
  }

  newObservable(id: Number, ): Observable<any> {
    return new Observable(observer => {
      const eventSource = this.newEventSource(id);
      eventSource.onmessage = event => {
        // console.log(event);
        observer.next(event);
      };
      eventSource.onerror = () => {
        if (eventSource.readyState !== eventSource.CONNECTING) {
          observer.error('An error occurred.');
        }
        eventSource.close();
        observer.complete();
      };
      return () => {
        eventSource.close();
      };
    });
  }
}
