import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { MenuComponent } from './menu/menu.component';


const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'menu/:category', component: MenuComponent,
    children: [
      { path: ':page', component: MenuComponent },
    ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
