import axios from 'axios'

import React, {useEffect, useState} from 'react'
const url="http://localhost:8080/url/allUrls";
const postLink = 'http://localhost:8080/url/save';


const SearchBar = () => {
  const [links, setLinks] =useState([[]])

  const [longUrl, setLongUrl] = useState('')
  const fetchLinks = () =>{

    
        axios.get(url).then(res=>{
          setLinks(res.data)
    
        });
    };
    useEffect(()=>{
      fetchLinks();
    
         
    },[])

   

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
  {links.map((link) => <li key = {link}>{link.shortUrl}</li>)}
<form onSubmit={handleSubmit}>
        <label htmlFor="header-search">
            <span className="visually-hidden">Search Links</span>
        </label>
        <input
            type="text"
            id="header-search"
            placeholder="Add New Link"
            name="s" 
            onChange={(e) => setLongUrl(e.target.value)}
            value={longUrl}
        />
        <button type="submit">Submit</button>
    </form>
<div>

</div>
</>
)
 

};

export default SearchBar;