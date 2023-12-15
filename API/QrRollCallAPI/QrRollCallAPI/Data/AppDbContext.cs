using Microsoft.EntityFrameworkCore;
using QrRollCallAPI.Models;
using System.Collections.Generic;

namespace QrRollCallAPI.Data
{
    public class AppDbContext : DbContext
    {

        public AppDbContext(DbContextOptions<AppDbContext> options): base(options){ }

        public DbSet<akademisyen> akademisyen { get; set; }

    }
}
