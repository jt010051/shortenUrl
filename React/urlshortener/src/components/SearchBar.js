import axios from 'axios'
import 'bootstrap/dist/css/bootstrap.css';
import Button from 'react-bootstrap/Button';

import React, {useEffect, useState} from 'react'
const url="http://localhost:8080/url/allUrls";
const postLink = 'http://localhost:8080/url/save';


const SearchBar = () => {
  const [links, setLinks] =useState([[]])

  const [longUrl, setLongUrl] = useState('')
const  protocol= "https://";

  const fetchLinks = () =>{

    
        axios.get(url).then(res=>{
          setLinks(res.data)
    
        });
    };
    useEffect(()=>{
      fetchLinks();
    
         
    },[])

   console.log(longUrl);



    const handleSubmit   = async(e)=>{
      const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ longUrl })
    };

     
    fetch(postLink, requestOptions)
    .then(response => response.json())
    .then(data => this.setState({ postId: data.id }));
      console.log(postLink);
    }


return(
  <>
  {links.map((link) => 
  <li>
  <a href={link.longUrl}>{link.shortUrl}</a>
  </li>
  
 )}
<form onSubmit={handleSubmit}>
        <label htmlFor="header-search">
            <span className="visually-hidden">Search Links</span>
        </label>
        <input
            type="text"
            id="header-search"
            placeholder="Add New Link"
            name="s" 
            onChange={(e) => setLongUrl(protocol +e.target.value)}
            value={longUrl}
        />
        <Button variant="primary" type='submit'>Submit</Button>{' '}

    </form>
<div>

</div>
</>
)
 

};

export default SearchBar;