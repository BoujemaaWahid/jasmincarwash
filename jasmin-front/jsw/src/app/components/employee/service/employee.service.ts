import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EmployeeModel } from 'src/app/models/EmployeeModel';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private url = "http://localhost:8080/employee"

  constructor(private http: HttpClient) { }

  public findAll(): Observable< Array<EmployeeModel> >{
    return this.http.get< Array<EmployeeModel> >(this.url)
  }
  public save(model: EmployeeModel): Observable<any>{
    return this.http.post(this.url, model, httpOptions) 
  }

  public update(model: EmployeeModel): Observable<any>{
    return this.http.put(this.url, model, httpOptions) 
  }

  public findOne(id: number): Observable<EmployeeModel>{
    return this.http.get<EmployeeModel>(this.url+'/'+id)
  }
}
