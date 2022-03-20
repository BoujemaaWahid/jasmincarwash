import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CentreModel } from 'src/app/models/CentreModel';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class CentreService {
  private url = "http://localhost:8080/centre"
  constructor(private http: HttpClient) { }

  findAll(): Observable< Array<CentreModel> >{
    return this.http.get< Array<CentreModel> >(this.url);
  }
  save(model: CentreModel): Observable<any>{
    return this.http.post(this.url, model, httpOptions) 
  }
}
