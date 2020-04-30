// import traverson from 'traverson'
// const apiUrl = '127.0.0.1/api'
//
// // eslint-disable-next-line no-unused-vars
// const ApiService = {
//     getByParams (resource, param = ' ') {
//         const request = traverson
//             .from(apiUrl)
//             .follow(`${resource}/${param}`)
//             .getResource((error, data) => {
//                 if (error) {
//                     // eslint-disable-next-line no-throw-literal
//                     throw `[MyKoiPond] ApiService ${resource} \n ${error}`
//                 } else {
//                     console.log('Followed the target resource data has been fetched')
//                     console.log(JSON.stringify(data))
//                 }
//             })
//         return request
//     },
//     get (resource, slug = ' ') {
//         const request = traverson
//             .from(apiUrl)
//             .follow(`${resource}/${slug}`)
//             .getResource((error, data) => {
//                 if (error) {
//                     // eslint-disable-next-line no-throw-literal
//                     throw `[MyKoiPond] ApiService ${resource} \n ${error}`
//                 } else {
//                     console.log('Followed the target resource data has been fetched')
//                     console.log(JSON.stringify(data))
//                 }
//             })
//         return request
//     },
//     post(resource, param){
//         const request = traverson
//             .from(apiUrl)
//             .follow(`${resource}/${param}`)
//             .post(param, (error, data) => {
//                 if (error) {
//                     // eslint-disable-next-line no-throw-literal
//                     throw `[MyKoiPond] ApiService ${resource} \n ${error}`
//                 } else {
//                     console.log('Followed the target resource data has been fetched')
//                     console.log(JSON.stringify(data))
//                 }
//             })
//         return request
//     },
//     checkError(error){
//         if (error.name === traverson.errors.HTTPError) {
//             // special handling for HTTP issues goes here
//             // eslint-disable-next-line no-throw-literal
//             throw '[MyKoiPond] ApiService HTTP Error'
//         } else if (error.name === traverson.errors.JSONError) {
//             // special handling for JSON parsing problems goes here
//             // eslint-disable-next-line no-throw-literal
//             throw '[MyKoiPond] ApiService Json parse Error'
//         } else if (error.name === traverson.errors.LinkError) {
//             // special handling for invalid or missing links goes here
//             // eslint-disable-next-line no-throw-literal
//             throw '[MyKoiPond] ApiService Link error Error'
//         } else {
//             // not so special handling for all other error conditions goes here
//             // eslint-disable-next-line no-throw-literal
//             throw '[MyKoiPond] ApiService Error in request'
//         }
//     }
// }
