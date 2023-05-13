## secretKey 생성 
```
SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
byte[] encodedKey = key.getEncoded();
String strKey = Base64.getEncoder().encodeToString(encodedKey);
```

## accessToken 생성
```
String jws = Jwts.builder()
               .setSubject() //String 값
               .signWith(key)
               .setIssuedAt() //발급 시간
               .setExpiration() //토큰 만료
               .compact();
```

## 값 가져오기
```
Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(appConfig.getJwtKey())
                .build()
                .parseClaimsJws(jws);
```
