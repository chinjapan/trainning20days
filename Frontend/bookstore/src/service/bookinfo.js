import axios from 'axios'

const Getallbook_URL = 'http://localhost:8080/api/v1/getallbookinfo';

class BookInfo{
    getallbookinfo(){
        return axios.get(Getallbook_URL);
    }
}

export default new BookInfo()