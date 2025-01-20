import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module'; 
import { ReactiveFormsModule } from '@angular/forms'; // For reactive forms
import { FormsModule } from '@angular/forms'; // For template-driven forms
import { HttpClientModule } from '@angular/common/http'; // For HTTP requests

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CategoriesComponent } from './categories/categories.component';
import { CartComponent } from './cart/cart.component';
import { ProductsComponent } from './products/products.component';
import { CheckoutComponent } from './checkout/checkout.component'; 
import { OrderComponent } from './order/order.component';
import { PaymentComponent } from './payment/payment.component';
import { ReviewComponent } from './review/review.component'; 

import { WelcomeComponent } from './welcome/welcome.component'; // Import WelcomeComponent
import { CartService } from './cart.service'; // Import CartService

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    CategoriesComponent,
    CartComponent,
    WelcomeComponent, // Include in declarations
    ProductsComponent,
    CheckoutComponent, 
    OrderComponent,
    PaymentComponent,
    ReviewComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [CartService],
  bootstrap: [AppComponent],
})
export class AppModule {}
