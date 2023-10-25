import axios from 'axios'
import 'bootstrap/dist/css/bootstrap.css';
import Button from 'react-bootstrap/Button';
import OverlayTrigger from 'react-bootstrap/OverlayTrigger';
import Tooltip from 'react-bootstrap/Tooltip';
import download from '../Images/download.png'
import { Overlay } from 'react-bootstrap';
import React, {useEffect, useState} from 'react'
const url="http://localhost:8080/url/allUrls";
const postLink = 'http://localhost:8080/url/save';


const SearchBar = () => {
  const [links, setLinks] =useState([[]])
  const [show, setShow] = useState(false);

  const [longUrl, setLongUrl] = useState('')
const  protocol= "https://";
function refreshPage() {
  window.location.reload(false);
}
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
      let fullUrl = ''

    if(!longUrl.includes("https://"))  fullUrl = protocol + longUrl;
      else fullUrl = longUrl;
      const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ fullUrl })
    };

     console.log(requestOptions);
    fetch(postLink, requestOptions)
    .then(response => response.json())
    .then(data => this.setState({ postId: data.id }));
      console.log(postLink);
      refreshPage()
    }


return(
  <>
  <img src={download} alt="Logo" />;
  {links.map((link) => 
  <li>
     <OverlayTrigger target={link.fullUrl}   overlay={<Tooltip id="button-tooltip-2">{link.fullUrl}</Tooltip>}
 placement="right">
  <Button variant="secondary" size="lg"><a href={link.fullUrl}>{link.shortUrl}</a></Button>
  </OverlayTrigger>
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
            onChange={(e) => setLongUrl(e.target.value)}
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