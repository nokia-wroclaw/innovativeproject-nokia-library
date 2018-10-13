import { Injectable } from '@angular/core';
import { API_URL } from '../../../config';
import axios from 'axios';
import { config } from 'rxjs/index';

@Injectable()
export class RestService {
	config = {
		headers: { 'Access-Control-Allow-Origin': '*' }
	};

	constructor() {
	}

	getAll<T>(resourceName: String) {

		const url = `${API_URL}/${resourceName}`;
		return axios.get(url)
		.then(function (response) {
			return response;
		}).catch((error) => {
			if (error.message === 'Network Error') {
				return error;
			}
			return error.response;
		});
	}
}
