import {Component, NgModule} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {AppHeaderComponent} from "./app-header/app-header.component";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, AppHeaderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

// @NgModule({
//   declarations: [],
//   imports: [
//     AppHeaderComponent,
//     FormsModule
//   ]
// })

export class AppComponent {
  title = 'bazaarUI';
}
