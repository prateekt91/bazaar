import {Component, NgModule} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {AppHeaderComponent} from "./app-header/app-header.component";
import {ProductDetailsComponent} from "./product-details/product-details.component";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, AppHeaderComponent, ProductDetailsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'bazaarUI';
}
