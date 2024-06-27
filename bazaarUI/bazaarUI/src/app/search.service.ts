import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private searchResultsSubject = new BehaviorSubject<any[]>([]);
  searchResults$ = this.searchResultsSubject.asObservable();

  constructor(private http: HttpClient) { }

  private baseUrl = 'http://localhost:8080'+'/api/v1';

  searchProduct(query: string): Observable<any> {
    let url: string;
    if(query.length<1) {
      url = `${this.baseUrl}/allProducts`;
    } else {
      url = `${this.baseUrl}/product/search/`+ query;
    }
    return this.http.get(url);
  }

  setSearchResults(results: any[]) {
    this.searchResultsSubject.next(results);
  }
}
