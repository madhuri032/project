import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user = {
    uname: '',
    uemail: '',
    upassword: '',
    uaddress: '',
    uage: null,
    uphonenumber: '' // Ensure this property exists for phone number
  };

  constructor(private router: Router) { }

  onSubmit() {
    console.log('Form submitted', this.user);
    // You can call a service to register the user and then redirect to login
    this.router.navigate(['/login']);
  }
}
