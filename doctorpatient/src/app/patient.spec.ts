import { Patient } from './patient';

// Other imports
import { TestBed } from '@angular/core/testing';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
describe('Patient', () => {
  it('should create an instance', () => {
    expect(new Patient()).toBeTruthy();
  });
});
