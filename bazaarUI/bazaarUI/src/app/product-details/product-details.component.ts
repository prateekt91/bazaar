import { Component, OnInit } from '@angular/core';
import {SearchService} from "../search.service";
import {Products} from "../model/Products";
import {DatePipe, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-product-details',
  standalone: true,
  imports: [
    NgIf,
    NgForOf,
    DatePipe
  ],
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.css'
})
export class ProductDetailsComponent implements OnInit {

  products: Products[] = [];

  constructor(private searchService: SearchService) {
  }
  ngOnInit(): void {
    this.searchService.searchResults$.subscribe(results=>{
      this.products = results;
    });
  }


}
