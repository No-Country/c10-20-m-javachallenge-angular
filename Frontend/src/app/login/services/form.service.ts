import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Action } from 'src/app/shared/models/action.model';

@Injectable({
  providedIn: 'root',
})
export class FormService {
  private _openForm = new BehaviorSubject<Action>({ type: '' });
  public $openForm = this._openForm.asObservable();

  public onOpenForm(accion: Action): void {
    this._openForm.next(accion);
  }
}
