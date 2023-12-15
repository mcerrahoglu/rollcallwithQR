using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using QrRollCallAPI.Data;
using System.Collections.Generic;
using System.Linq;
using QrRollCallAPI.Models;



namespace QrRollCallAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AkademisyenController : ControllerBase
    {

        private readonly AppDbContext _context;

        public AkademisyenController(AppDbContext context)
        {
            _context = context;
        }


        [HttpGet]
        public IActionResult Get()
        {
            var akademisyenler = _context.akademisyen.ToList();
            return Ok(akademisyenler);
        }

        [HttpGet("akademisyenGiris/{id}/{sifre}")]  
        public IActionResult akademisyenGiris(int id, string sifre)
        {
            var sonuc = _context.akademisyen.Where(x=>x.ak_no == id && x.ak_sifre == sifre).FirstOrDefault();
            if(sonuc != null)
            {
                AkademisyenAdSoyadResponse model = new AkademisyenAdSoyadResponse()
                {
                    ak_ad = sonuc.ak_ad,
                    ak_soyad = sonuc.ak_soyad
                };
                return Ok(model);
            }


            return Ok();

        }


    }
}
