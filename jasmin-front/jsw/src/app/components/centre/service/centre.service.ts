import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CentreModel } from 'src/app/models/CentreModel';

@Injectable({
  providedIn: 'root'
})
export class CentreService {
  private url = "http://localhost:8080/centre"
  constructor(private http: HttpClient) { }

  findAll(): Observable<CentreModel>{
   this.url = "https://jsonplaceholder.typicode.com/posts/1"
    return this.http.get(this.url);
  }
}
