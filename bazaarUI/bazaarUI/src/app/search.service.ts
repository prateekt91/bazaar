import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) { }

  private baseUrl = 'http://localhost:8080'+'/api/v1';

  searchProduct(query: string): Observable<any> {
    const url = `${this.baseUrl}/product/search/`+ query;

    return this.http.get(url);
  }
}
