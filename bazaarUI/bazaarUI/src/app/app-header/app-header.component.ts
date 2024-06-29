import {Component, OnInit} from '@angular/core';
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
export class AppHeaderComponent implements OnInit{

  navLinksVisible = false;
  searchQuery: string = '';
  //searchedProducts: Products[] = [];

  toggleNavLinks() {
    this.navLinksVisible = !this.navLinksVisible;
  }

  constructor(private searchService: SearchService) {}

  onSearch()  {
      this.searchService.searchProduct(this.searchQuery).subscribe(
        (response) => {
          console.log('search result',response);
          //TODO Handle result here
          if(response) {
            this.searchService.setSearchResults(response);
          }
        },
        error => {
          console.error("Error occurred during search result", error);
        }
      );
    }

  protected readonly KeyboardEvent = KeyboardEvent;

  ngOnInit(): void {
    this.onSearch();
  }

  refreshPage(): void {
    location.reload();
  }
}
