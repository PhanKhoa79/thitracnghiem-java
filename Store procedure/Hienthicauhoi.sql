delimiter //

CREATE PROCEDURE hienthi_cauhoi()
BEGIN
    SELECT CAUHOI.IdCauHoi, CAUHOI.CauHoi, CAUHOI.Dap_An_A, CAUHOI.Dap_An_B, CAUHOI.Dap_An_C, CAUHOI.Dap_An_D, CAUHOI.DapAnDung, MONTHI.TenMonThi, MUCDO.TenMucDo, CHUONG.TenChuong
    FROM CAUHOI
    INNER JOIN Chuong ON CAUHOI.IdChuong = Chuong.IdChuong
    INNER JOIN MONTHI ON CAUHOI.IdMonThi = MONTHI.IdMonThi
    INNER JOIN MUCDO ON CAUHOI.IdMucDo = MUCDO.IdMucDo;
END //

delimiter;

DELIMITER //

CREATE PROCEDURE hienthi_cauhoi_1(monthi VARCHAR(20))
BEGIN
    SELECT CAUHOI.IdCauHoi, CAUHOI.CauHoi, CAUHOI.Dap_An_A, CAUHOI.Dap_An_B, CAUHOI.Dap_An_C, CAUHOI.Dap_An_D, CAUHOI.DapAnDung, MONTHI.TenMonThi, MUCDO.TenMucDo, CHUONG.TenChuong 
    FROM CAUHOI
    INNER JOIN Chuong ON CAUHOI.IdChuong = Chuong.IdChuong
    INNER JOIN MONTHI ON CAUHOI.IdMonThi = MONTHI.IdMonThi
    INNER JOIN MUCDO ON CAUHOI.IdMucDo = MUCDO.IdMucDo
    WHERE MONTHI.IdMonThi = monthi;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE hienthi_cauhoi_2(
    mucdo VARCHAR(20),
    monthi VARCHAR(20)
)
BEGIN
    SELECT CAUHOI.IdCauHoi, CAUHOI.CauHoi, CAUHOI.Dap_An_A, CAUHOI.Dap_An_B, CAUHOI.Dap_An_C, CAUHOI.Dap_An_D, CAUHOI.DapAnDung, MONTHI.TenMonThi, MUCDO.TenMucDo, CHUONG.TenChuong 
    FROM CAUHOI
    INNER JOIN Chuong ON CAUHOI.IdChuong = Chuong.IdChuong
    INNER JOIN MONTHI ON CAUHOI.IdMonThi = MONTHI.IdMonThi
    INNER JOIN MUCDO ON CAUHOI.IdMucDo = MUCDO.IdMucDo
    WHERE CAUHOI.IdMucDo = mucdo AND CAUHOI.IdMonThi = monthi;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE hienthi_cauhoi_3(
    chuong VARCHAR(20),
    monthi VARCHAR(20)
)
BEGIN
    SELECT CAUHOI.IdCauHoi, CAUHOI.CauHoi, CAUHOI.Dap_An_A, CAUHOI.Dap_An_B, CAUHOI.Dap_An_C, CAUHOI.Dap_An_D, CAUHOI.DapAnDung, MONTHI.TenMonThi, MUCDO.TenMucDo, CHUONG.TenChuong 
    FROM CAUHOI
    INNER JOIN Chuong ON CAUHOI.IdChuong = Chuong.IdChuong
    INNER JOIN MONTHI ON CAUHOI.IdMonThi = MONTHI.IdMonThi
    INNER JOIN MUCDO ON CAUHOI.IdMucDo = MUCDO.IdMucDo
    WHERE Chuong.IdChuong = chuong AND MONTHI.IdMonThi = monthi;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE update_CauHoii(
    IdCauHoi INT,
    CauHoi VARCHAR(200),
    Dap_An_A VARCHAR(100),
    Dap_An_B VARCHAR(100),
    Dap_An_C VARCHAR(100),
    Dap_An_D VARCHAR(100),
    DapAnDung VARCHAR(100),
    IdMonThi VARCHAR(20),
    IdMucDo VARCHAR(20),
    IdChuong VARCHAR(20)
)
BEGIN
    UPDATE CAUHOI SET 
        CauHoi = CauHoi, 
        Dap_An_A = Dap_An_A, 
        Dap_An_B = Dap_An_B, 
        Dap_An_C = Dap_An_C, 
        Dap_An_D = Dap_An_D, 
        DapAnDung = DapAnDung, 
        IdMonThi = IdMonThi, 
        IdMucDo = IdMucDo, 
        IdChuong = IdChuong 
    WHERE IdCauHoi = IdCauHoi;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE xoa_cauHoii(
    cauhoi VARCHAR(200)
)
BEGIN
    DELETE FROM CAUHOI WHERE CauHoi = cauhoi;
END //

DELIMITER ;