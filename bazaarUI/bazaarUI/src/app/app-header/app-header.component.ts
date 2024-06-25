import { Component } from '@angular/core';
import {NgOptimizedImage} from "@angular/common";
import {SearchService} from "../search.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    NgOptimizedImage,
    FormsModule
  ],
  templateUrl: './app-header.component.html',
  styleUrl: './app-header.component.css'
})
export class AppHeaderComponent {

  navLinksVisible = false;
  searchQuery: string = '';

  toggleNavLinks() {
    this.navLinksVisible = !this.navLinksVisible;
  }

  constructor(private searchService: SearchService) {}

  onSearch()  {
    if(this.searchQuery) {
      this.searchService.searchProduct(this.searchQuery).subscribe(
        (response) => {
          console.log('search result',response);
          //TODO Handle result here
        },
        error => {
          console.error("Error occurred during search result", error);
        }
      );
    }
  }
}
