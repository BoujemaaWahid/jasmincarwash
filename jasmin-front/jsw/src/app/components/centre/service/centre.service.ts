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
    return this.http.get< Array<CentreModel> >(this.url+"/all");
  }
  findById(id: number): Observable<CentreModel>{
    return this.http.get<CentreModel>(this.url+"/id/"+id)
  }
  streamAll():Observable< Array<CentreModel> >{
    const eventSource = new EventSource(this.url)
    return new Observable( res=>{
      this.findAll().subscribe(all=> res.next(all))
      eventSource.onmessage = (event) =>{
        let list = JSON.parse( event.data ) as Array<CentreModel>
        res.next(list)
      }
      eventSource.onerror = (event) => res.error([])
      return ()=> eventSource.close()
    })
  }

  save(model: CentreModel): Observable<any>{
    return this.http.post(this.url, model, httpOptions) 
  }
  update(model: CentreModel): Observable<any>{
    return this.http.put(this.url, model, httpOptions) 
  }
  withNoneResponsable(): Observable< Array<CentreModel> >{
    return this.http.get< Array<CentreModel> >(this.url+"/none-responsable")
  }

  getMonthsName(): Array<string>{
    return ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Decembre']
  }
}
