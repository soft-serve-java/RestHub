import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import {CookComponent} from "./cook/cook.component";


const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'cook', component: CookComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
