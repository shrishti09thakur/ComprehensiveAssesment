import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {HttpClientModule} from '@angular/common/http';
import { PatientService } from './patient.service';



describe('PatientService', () => {

      beforeEach(() => TestBed.configureTestingModule({
        imports: [HttpClientTestingModule], 
        providers: [PatientService]
      }));

       it('should create Patient', () => {
        const service: PatientService = TestBed.get(PatientService);
        expect(service).toBeTruthy();
       });

      //  it('should have getData function', () => {
      //   const service: PatientService = TestBed.get(PatientService);
      //   expect(service.get).toBeTruthy();
      //  });

    });