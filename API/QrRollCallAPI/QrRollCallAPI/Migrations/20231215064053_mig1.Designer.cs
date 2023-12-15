﻿// <auto-generated />
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using Npgsql.EntityFrameworkCore.PostgreSQL.Metadata;
using QrRollCallAPI.Data;

#nullable disable

namespace QrRollCallAPI.Migrations
{
    [DbContext(typeof(AppDbContext))]
    [Migration("20231215064053_mig1")]
    partial class mig1
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "6.0.25")
                .HasAnnotation("Relational:MaxIdentifierLength", 63);

            NpgsqlModelBuilderExtensions.UseIdentityByDefaultColumns(modelBuilder);

            modelBuilder.Entity("QrRollCallAPI.Models.akademisyen", b =>
                {
                    b.Property<int>("ak_no")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("integer");

                    NpgsqlPropertyBuilderExtensions.UseIdentityByDefaultColumn(b.Property<int>("ak_no"));

                    b.Property<string>("ak_ad")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<string>("ak_sifre")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<string>("ak_soyad")
                        .IsRequired()
                        .HasColumnType("text");

                    b.Property<int>("ak_tc")
                        .HasColumnType("integer");

                    b.HasKey("ak_no");

                    b.ToTable("akademisyen");
                });
#pragma warning restore 612, 618
        }
    }
}
