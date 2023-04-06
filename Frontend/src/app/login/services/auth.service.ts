import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { JWTResponse } from 'src/app/shared/models/jwtresponse.model';
import { LoginUser } from 'src/app/shared/models/login-user.model';
import { Message } from 'src/app/shared/models/message.model';
import { User } from 'src/app/shared/models/user.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private endpoint: string = `${environment.APIUrl}/auth`;

  private _isLogged: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(
    false
  );

  public $isLogged = this._isLogged.asObservable();

  constructor(private http: HttpClient) {}

  public signup(user: User): Observable<Message> {
    return this.http.post<Message>(`${this.endpoint}/signup`, user);
  }

  public signin(loginUser: LoginUser): Observable<JWTResponse> {
    return this.http.post<JWTResponse>(`${this.endpoint}/signin`, loginUser);
  }

  public isLogged(logged: boolean): void {
    this._isLogged.next(logged);
  }
}
