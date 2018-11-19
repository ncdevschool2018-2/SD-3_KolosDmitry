import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {UserIDService} from './http.IDservice';
import {UserModel} from '../model/UserModel';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  constructor(private http: HttpClient) {

  }

  getSubscriptions(): Observable<any> {
    return this.http.get('../assets/subscriptions.json')
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }

  getUsers(): Observable<any> {
    return this.http.get('../assets/users.json')
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }

  deleteSubscription(id: string): Observable<any> {
    return this.http.get('../assets/subscriptions.json', {params: {id}})
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }

  setUser(user: UserModel): Observable<UserModel> {
    console.log('new user');
    return this.http.post<UserModel>('http://localhost:8081/api/', user);
  }
}
