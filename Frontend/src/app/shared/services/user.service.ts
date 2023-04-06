import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private endpoint: string = `${environment.APIUrl}/user`;

  constructor(private http: HttpClient) {}

  public findUserByEmail(email: string): Observable<User> {
    return this.http.get<User>(`${this.endpoint}/${email}`);
  }
}
