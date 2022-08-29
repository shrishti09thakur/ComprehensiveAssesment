import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {HttpClientModule} from '@angular/common/http';
import { DoctorService } from './doctor.service';



describe('DoctorService', () => {

      beforeEach(() => TestBed.configureTestingModule({
        imports: [HttpClientTestingModule], 
        providers: [DoctorService]
      }));

       it('should create DoctorService', () => {
        const service: DoctorService = TestBed.get(DoctorService);
        expect(service).toBeTruthy();
       });

      //  it('should have getData function', () => {
      //   const service: PatientService = TestBed.get(PatientService);
      //   expect(service.get).toBeTruthy();
      //  });

    });