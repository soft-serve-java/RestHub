import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import {WaiterTablesComponent} from "./waiter-tables/waiter-tables.component";


const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'waiter', component: WaiterTablesComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
