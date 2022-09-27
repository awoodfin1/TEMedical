import axios from 'axios';

export default {

  viewMyProviderAvailability(){
    return axios.get('/appointment')
  }

}