const data = [
    {
        id: "Admin",
        icon: "iconsminds-administrator",
        label: "menu.admin",
        to: "/admin",
        subs: [
            {
                icon: "iconsminds-fish",
                label: "menu.breed",
                to: "/breed",
            },
            {
                icon: "iconsminds-fish",
                label: "menu.subBreed",
                to: "/subbreed",
            },
            {
                icon: "iconsminds-fish",
                label: "menu.parasite",
                to: "/parasite",
            },
        ]
    },
    {
        icon: "iconsminds-fish",
        label: "menu.pond",
        to: "/pond",
    },
];
export default data;
