import React, { Component } from 'react';
import bookinfoservice from '../service/bookinfo.js';

class Listbookinfo extends Component {
    constructor(props){
        super(props)
        this.state ={
            bookinfo :[]
        }
    }

    componentDidMount(){
        bookinfoservice.getallbookinfo().then((res)=> {
            this.setState({bookinfo:res.data});
        })
    }
    render() {
        return (
            <div>
                <h2 className="text-center">BookInfo</h2>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thread>
                            <tr>
                                <th>bookname</th>
                                <th>companyname</th>
                                <th>createdate</th>
                                <th>cost</th>
                                <th>pagenumber</th>
                            </tr>
                        </thread>
                        <tbody>
                            {
                                this.state.bookinfo.map(
                                    bookinfo => 
                                    <tr key={bookinfo.id}>
                                        <td>{bookinfo.bookname}</td>
                                        <td>{bookinfo.companyname}</td>
                                        <td>{bookinfo.createdate}</td>
                                        <td>{bookinfo.cost}</td>
                                        <td>{bookinfo.pagenumber}</td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default Listbookinfo;